package com.s3.io.tryer.contoller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.transfer.Download;
import com.amazonaws.services.s3.transfer.TransferManager;
import com.amazonaws.services.s3.transfer.TransferManagerBuilder;
import com.google.gson.Gson;
import com.s3.io.tryer.util.FileUtil;

@RequestMapping("/file")
@RestController
public class FileController {

	private static final String BUCKETNAME = "batuhan-tryer-first-stack";

	private static final String FILEKEY = "temp_event";

	private static final String FILEZIPKEY = "temp_event_zip";

	private TransferManager transferManager;

	private Gson gson;

	@Autowired
	private AmazonS3 s3Client;

	@Autowired
	private ExecutorService executorService;

	@PostConstruct
	private void init() {
		this.gson = new Gson();
		this.transferManager = TransferManagerBuilder.standard().withS3Client(this.s3Client)
				.withExecutorFactory(() -> executorService).build();
	}

	@GetMapping("/upload")
	public void uploadFile() {

		InputStream input = FileUtil.getfile("/data/temp_event");
		long t1 = System.currentTimeMillis();
		ByteArrayInputStream dataIs = null;

		try {
			byte[] data = FileUtil.toByteArray(input);
			ObjectMetadata metaData = new ObjectMetadata();
			metaData.setContentLength(data.length);
			metaData.setContentType("plain/text");
			dataIs = new ByteArrayInputStream(data);
			PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME, FILEKEY, dataIs, metaData);

			this.s3Client.putObject(putObjectRequest);
			long t2 = System.currentTimeMillis() - t1;
			System.err.println("upload takes = " + t2 + "ms");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				dataIs.close();
				input.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

	@GetMapping("/uploadZip")
	public void uploadFileZip() {

		InputStream input = FileUtil.getfile("/data/temp_event");
		byte[] byteData = null;
		try {
			byteData = FileUtil.toByteArray(input);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		long t1 = System.currentTimeMillis();
		ByteArrayInputStream dataIs = null;

		try {
			byte[] data = FileUtil.gzip(byteData);
			// byte[] data = FileUtil.compress(FileUtil.toByteArray(input2));

			ObjectMetadata metaData = new ObjectMetadata();
			metaData.setContentLength(data.length);
			metaData.setContentType("application/zip");
			dataIs = new ByteArrayInputStream(data);
			PutObjectRequest putObjectRequest = new PutObjectRequest(BUCKETNAME, FILEZIPKEY, dataIs, metaData);

			this.s3Client.putObject(putObjectRequest);
			long t2 = System.currentTimeMillis() - t1;
			dataIs.close();
			System.err.println("zipped upload takes = " + t2 + "ms");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				dataIs.close();
				input.close();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
	}

//	@GetMapping("/download")
//	public void downloadFile() {
//
//		List<Event> events = new ArrayList<>();
//		File temp = null;
//		try {
//
//			temp = File.createTempFile("tempfile", ".tmp");
//
//			long t1 = System.currentTimeMillis();
//			this.downloadFileParalel(BUCKETNAME, FILEKEY, temp);
//			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(temp.getAbsolutePath()))) {
//				String line;
//				while ((line = bufferedReader.readLine()) != null) {
//					Event event = gson.fromJson(line, Event.class);
//					events.add(event);
//				}
//			}
//
//			long t2 = System.currentTimeMillis() - t1;
//			System.err.println("download takes = " + t2 + "ms");
//
//			temp.delete();
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		} finally {
//			if (temp != null) {
//				if (temp.exists()) {
//					temp.delete();
//				}
//			}
//		}
//
//		System.err.println(events.size());
//	}
//
//	@GetMapping("/downloadZip")
//	public void downloadZipFile() {
//
//		List<Event> events = new ArrayList<>();
//		File zipFile = null;
//		
//		FileInputStream fi = null;
//		GZIPInputStream in = null;
//
//		Reader decoder = null;
//		BufferedReader br = null;
//		
//		try {
//			zipFile = File.createTempFile("tempfile", ".zip");
//
//			long t1 = System.currentTimeMillis();
//			this.downloadFileParalel(BUCKETNAME, FILEZIPKEY, zipFile);
//
//			fi = new FileInputStream(zipFile);
//			in = new GZIPInputStream(fi);
//
//			decoder = new InputStreamReader(in);
//			br = new BufferedReader(decoder);
//
//			String line;
//			while ((line = br.readLine()) != null) {
//				events.add(gson.fromJson(line, Event.class));
//			}
//
//			long t2 = System.currentTimeMillis() - t1;
//			System.err.println("zipped download takes = " + t2 + "ms");
//		
//			zipFile.delete();
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		} finally {
//			if (zipFile != null) {
//				if (zipFile.exists()) {
//					zipFile.delete();
//				}
//			}
//			try {
//				br.close();
//				decoder.close();
//				in.close();
//				fi.close();
//
//			} catch (Exception e2) {
//				System.err.println(e2.getMessage());
//			}
//		}
//
//		System.err.println(events.size());
//	}

	private void downloadFileParalel(String bucket, String key, File file) {
		try {
			long t1 = System.currentTimeMillis();
			Download myDownload = transferManager.download(bucket, key, file, 300000);
			myDownload.waitForCompletion();
			long t2 = System.currentTimeMillis() - t1;
			System.err.println("Paralel Download takes = " + t2 + "ms");
		} catch (AmazonClientException | InterruptedException e) {
			System.err.println(e.getMessage());
		}
	}
}

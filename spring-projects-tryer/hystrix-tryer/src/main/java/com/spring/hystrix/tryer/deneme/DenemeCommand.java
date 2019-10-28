package com.spring.hystrix.tryer.deneme;

import com.netflix.hystrix.HystrixCommand;

public class DenemeCommand extends HystrixCommand<Void>{

	protected DenemeCommand(Setter setter) {
		super(setter);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Void run() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

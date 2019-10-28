package com.unit.test.tryer.unit.test.wihtout.spring;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import java.awt.Point;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import com.unit.test.tryer.unit.test.wihtout.spring.commandpattern.DenemeContext;
import com.unit.test.tryer.unit.test.wihtout.spring.commandpattern.Move.MoveType;


@RunWith(Parameterized.class)
public class MoveTestWithParameterized {
	@Parameters(name = "{{index}}")
	public static Collection<Object[]> data() {
		return Arrays.asList(new Object[][] { { MoveType.UP, new Point(4, 3) }, { MoveType.DOWN, new Point(4, 5) },
				{ MoveType.LEFT, new Point(3, 4) }, { MoveType.RIGHT, new Point(5, 4) } });
	}

	@Parameter(0)
	public MoveType input;

	@Parameter(1)
	public Point outPut;

	private DenemeContext denemeContext;

	@Before
	public void init() {
		this.denemeContext = new DenemeContext(new Point(4, 4));
	}

	@Test
	public void moveTest() {
		Point result = denemeContext.getNextPoint(input);
		assertThat(result, equalTo(outPut));
	}
}

package org.skii.algorithm;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SkiingSingaporeTest {
	 
	@Test()
	public void testA(){
		Integer[][] input={ {2,3},{3,4}};
		List<Integer> output=SkiingSingapore.skiingAlgorithm(2, 2, input);
		Assert.assertEquals(3, output.size());
		Assert.assertEquals(2, output.get(0).intValue());
		Assert.assertEquals(3, output.get(1).intValue());
		Assert.assertEquals(4, output.get(2).intValue());
	}
	
	@Test()
	public void testB(){
		Integer[][] input={ {4, 8, 7, 3 },{2, 5, 9, 3},{6, 3, 2, 5},{4, 4, 1, 6}};
		List<Integer> output=SkiingSingapore.skiingAlgorithm(4, 4, input);
		Assert.assertEquals(5, output.size());
		Assert.assertEquals(1, output.get(0).intValue());
		Assert.assertEquals(2, output.get(1).intValue());
		Assert.assertEquals(3, output.get(2).intValue());
		Assert.assertEquals(5, output.get(3).intValue());
		Assert.assertEquals(9, output.get(4).intValue());
	}
}

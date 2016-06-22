package com.metricstream.surefire;

import java.util.Date;

/**
 * The Class Bean : A model to store the result 
 * @author vivek.agrawal
 */
public class Bean {
	
	/** The module name. */
	private String moduleName;
	
	/** The total tests. */
	private Integer totalTests;
	
	/** The total passed tests. */
	private Integer totalPassedTests;
	
	/** The run date. */
	private Date runDate;
	
	/**
	 * Gets the module name.
	 *
	 * @return the module name
	 */
	public String getModuleName() {
		return moduleName;
	}
	
	/**
	 * Sets the module name.
	 *
	 * @param moduleName the new module name
	 */
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	
	/**
	 * Gets the total tests.
	 *
	 * @return the total tests
	 */
	public Integer getTotalTests() {
		return totalTests;
	}
	
	/**
	 * Sets the total tests.
	 *
	 * @param totalTests the new total tests
	 */
	public void setTotalTests(Integer totalTests) {
		this.totalTests = totalTests;
	}
	
	/**
	 * Gets the total passed tests.
	 *
	 * @return the total passed tests
	 */
	public Integer getTotalPassedTests() {
		return totalPassedTests;
	}
	
	/**
	 * Sets the total passed tests.
	 *
	 * @param totalPassedTests the new total passed tests
	 */
	public void setTotalPassedTests(Integer totalPassedTests) {
		this.totalPassedTests = totalPassedTests;
	}
	
	/**
	 * Gets the run date.
	 *
	 * @return the run date
	 */
	public Date getRunDate() {
		return runDate;
	}
	
	/**
	 * Sets the run date.
	 *
	 * @param runDate the new run date
	 */
	public void setRunDate(Date runDate) {
		this.runDate = runDate;
	}
	
	
	
}

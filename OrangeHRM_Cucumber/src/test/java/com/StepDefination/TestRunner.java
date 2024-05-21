package com.StepDefination;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( features="OrangeHRMApplication",glue="com.StepDefination",monochrome=true )

public class TestRunner {

}

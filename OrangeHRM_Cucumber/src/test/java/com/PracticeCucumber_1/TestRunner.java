package com.PracticeCucumber_1;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="PracticeCucumber",glue="com.PracticeCucumber_1",monochrome=true, tags="@Smoke,@RegressionTesting")

public class TestRunner {

}

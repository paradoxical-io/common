package io.paradoxical.common.tests;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class TestBase {
	
	protected PodamFactory fixture = new PodamFactoryImpl();
	
	public TestBase() {
	}
}

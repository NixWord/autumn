package fr.clubnix.autumn.junit;

import org.junit.Test;

import fr.clubnix.autumn.Autumn;

public class AutumnTest {

	@Test
	public void canRun() {
		Autumn autumn = new Autumn();

		autumn.run(null);
	}
}

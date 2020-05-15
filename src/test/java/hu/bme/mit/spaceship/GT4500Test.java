package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

		private TorpedoStore primary;
		private TorpedoStore secondary;
  private GT4500 ship;

  @BeforeEach
  public void init(){
    primary = mock(TorpedoStore.class);
    secondary = mock(TorpedoStore.class);
    ship = new GT4500(primary, secondary);
  }

  @Test
  public void fireTorpedo_Single_Success() {
    // Arrange
				when(primary.fire(1)).thenReturn(true);

    // Act
    boolean result = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
				assertEquals(true, result);
				
				verify(primary, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange
				when(primary.fire(1)).thenReturn(true);
				when(secondary.fire(1)).thenReturn(true);
    // Act
    boolean result = ship.fireTorpedo(FiringMode.ALL);

    // Assert
				assertEquals(true, result);
				
		}
		
		@Test
  public void fireTorpedo_three_times(){
    // Arrange
				when(primary.fire(1)).thenReturn(true);
				when(secondary.fire(1)).thenReturn(true);
    // Act
				boolean result0 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
				assertEquals(true, result0);
				assertEquals(true, result1);
				assertEquals(true, result2);
				
				verify(primary, times(2)).fire(1);
				verify(secondary, times(1)).fire(1);
  }

		@Test
  public void fireTorpedo_four_times(){
    // Arrange
				when(primary.fire(1)).thenReturn(true);
				when(secondary.fire(1)).thenReturn(true);
    // Act
				boolean result0 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result3 = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
				assertEquals(true, result0);
				assertEquals(true, result1);
				assertEquals(true, result2);
				assertEquals(true, result3);
				
				verify(primary, times(2)).fire(1);
				verify(secondary, times(2)).fire(1);
  }

		@Test
  public void fireTorpedo_five_times(){
    // Arrange
				when(primary.fire(1)).thenReturn(true);
				when(secondary.fire(1)).thenReturn(true);
    // Act
				boolean result0 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result3 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result4 = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
				assertEquals(true, result0);
				assertEquals(true, result1);
				assertEquals(true, result2);
				assertEquals(true, result3);
				assertEquals(true, result4);
				
				verify(primary, times(3)).fire(1);
				verify(secondary, times(2)).fire(1);
  }

		@Test
  public void fireTorpedo_six_times(){
    // Arrange
				when(primary.fire(1)).thenReturn(true);
				when(secondary.fire(1)).thenReturn(true);
    // Act
				boolean result0 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result3 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result4 = ship.fireTorpedo(FiringMode.SINGLE);
				boolean result5 = ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
				assertEquals(true, result0);
				assertEquals(true, result1);
				assertEquals(true, result2);
				assertEquals(true, result3);
				assertEquals(true, result4);
				assertEquals(true, result5);
				
				verify(primary, times(3)).fire(1);
				verify(secondary, times(3)).fire(1);
  }

		@Test
  public void fireTorpedo_seven_times(){
			// Arrange
			when(primary.fire(1)).thenReturn(true);
			when(secondary.fire(1)).thenReturn(true);
			// Act
			boolean result0 = ship.fireTorpedo(FiringMode.SINGLE);
			boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);
			boolean result2 = ship.fireTorpedo(FiringMode.SINGLE);
			boolean result3 = ship.fireTorpedo(FiringMode.SINGLE);
			boolean result4 = ship.fireTorpedo(FiringMode.SINGLE);
			boolean result5 = ship.fireTorpedo(FiringMode.SINGLE);
			boolean result6 = ship.fireTorpedo(FiringMode.SINGLE);

			// Assert
			assertEquals(true, result0);
			assertEquals(true, result1);
			assertEquals(true, result2);
			assertEquals(true, result3);
			assertEquals(true, result4);
			assertEquals(true, result5);
			assertEquals(true, result6);
			
			verify(primary, times(4)).fire(1);
			verify(secondary, times(3)).fire(1);
	}

	@Test
	public void fireTorpedo_failure(){
			// Arrange
			when(primary.isEmpty()).thenReturn(true);
			when(primary.fire(1)).thenReturn(false);

			// Act
			boolean result = ship.fireTorpedo(FiringMode.SINGLE);

			// Assert
			assertEquals(false, result);
	}

		@Test
	public void fireTorpedo_secondary_empty(){
			// Arrange
			when(secondary.isEmpty()).thenReturn(true);
			when(primary.fire(1)).thenReturn(true);

			// Act
			boolean result0 = ship.fireTorpedo(FiringMode.SINGLE);
			boolean result1 = ship.fireTorpedo(FiringMode.SINGLE);
			// Assert
			assertEquals(true, result0);
			assertEquals(true, result1);

			verify(secondary, times(0)).fire(1);
	}

	@Test
	public void fireLaser(){
			// Arrange

			// Act
			boolean result = ship.fireLaser(FiringMode.SINGLE);
			// Assert
			assertEquals(false, result);
	}

}

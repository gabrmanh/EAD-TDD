import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class DroneDeliveryServiceTest {
    private final DroneDeliveryService sut = new DroneDeliveryService();

    @Nested
    @DisplayName("Valid Classes")
    class ValidClasses {

        @Test
        @DisplayName("Should return 'S' if the box can fit in the window given box values smaller than the window")
        public void deliverSuccess() {
            char result = sut.deliver(1, 2, 3, 4, 5);
            assertThat(result).isEqualTo('S');
        }

        @Test
        @DisplayName("Should return 'S' if two of the box's sides are smaller than the window")
        public void deliverSuccessTwoSmaller()
        {
            char result = sut.deliver(10, 5, 3, 6, 4);
            assertThat(result).isEqualTo('S');
        }
        
        @Test
        @DisplayName("Should return 'S' if at least two box sides are equal to the window sizes")
        public void deliverSuccessEqual(){
            char result = sut.deliver(20, 10, 5, 10, 5);
            assertThat(result).isEqualTo('S');
        }
    }
}

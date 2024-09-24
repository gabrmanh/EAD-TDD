import com.sun.source.tree.NewArrayTree;
import org.assertj.core.api.Assertions;
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
        @DisplayName("Should return 'S' if at least two box sides are equal to the window's sides")
        public void deliverSuccessEqual(){
            char result = sut.deliver(20, 10, 5, 10, 5);
            assertThat(result).isEqualTo('S');
        }
    }
    
    @Nested
    @DisplayName("Invalid Classes")
    class InvalidClasses {
        @Test
        @DisplayName("Should return 'N' if only one of the box's sides is smaller than both window sides")
        public void deliverFailureOneSmaller(){
            char result = sut.deliver(20, 30, 5, 10, 5);
            assertThat(result).isEqualTo('N');
        }

        @Test
        @DisplayName("Should return 'N' if all of the box's sides are bigger than the window")
        public void deliverFailureAllBigger(){
            char result = sut.deliver(80, 90, 10, 2, 3);
            assertThat(result).isEqualTo('N');
        }

    }
}

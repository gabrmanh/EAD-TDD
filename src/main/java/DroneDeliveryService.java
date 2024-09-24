public class DroneDeliveryService {
    public char deliver(int a, int b, int c, int h, int l) {
        if (a < 1 || b < 1 || c < 1 || h < 1 || l < 1)
            throw new IllegalArgumentException("All values must be positive integers.");
        if(
                (a <= h && b <= l)
                || (a <= l && b <= h)
                || (a <= h && c <= l)
                || (a <= l && c <= h)
                || (b <= h && c <= l)
                || (b <= l && c <= h)
        ) return 'S';
        return 'N';
    }
}

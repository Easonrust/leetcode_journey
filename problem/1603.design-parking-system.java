/*
 * @lc app=leetcode id=1603 lang=java
 *
 * [1603] Design Parking System
 */

// @lc code=start
class ParkingSystem {
 Map<Integer, Integer> map;

 public ParkingSystem(int big, int medium, int small) {
  map = new HashMap<>();
  map.put(1, big);
  map.put(2, medium);
  map.put(3, small);
 }

 public boolean addCar(int carType) {
  if (map.get(carType) == 0) {
   return false;
  } else {
   map.put(carType, map.get(carType) - 1);
   return true;
  }
 }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small); boolean param_1 =
 * obj.addCar(carType);
 */

// too easy
/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small); boolean param_1 =
 * obj.addCar(carType);
 */
// @lc code=end

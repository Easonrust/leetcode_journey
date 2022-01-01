class SnakeGame {

 int[] curFood;
 int score;
 Queue<int[]> foodQueue;
 Deque<int[]> snake;
 int w, h;

 public SnakeGame(int width, int height, int[][] food) {
  w = width;
  h = height;
  foodQueue = new LinkedList<>();
  snake = new ArrayDeque<>();
  for (int[] f : food) {
   foodQueue.offer(f);
  }
  curFood = foodQueue.poll();
  snake.add(new int[] { 0, 0 });
  score = 0;
 }

 public int move(String direction) {
  int[] head = snake.peekFirst();
  int nextX = 0, nextY = 0;
  switch (direction) {
   case "U":
    nextX = head[0] - 1;
    nextY = head[1];
    return checkResult(nextX, nextY);

   case "D":
    nextX = head[0] + 1;
    nextY = head[1];
    return checkResult(nextX, nextY);
   case "L":
    nextX = head[0];
    nextY = head[1] - 1;
    return checkResult(nextX, nextY);
   case "R":
    nextX = head[0];
    nextY = head[1] + 1;
    return checkResult(nextX, nextY);
   default:
    return -1;
  }
 }

 private int checkResult(int nextX, int nextY) {
  if (nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) {
   // hit wall
   return -1;
  }

  if (nextX == curFood[0] && nextY == curFood[1]) {
   // eat food

   // 1. add new food
   if (!foodQueue.isEmpty()) {
    curFood = foodQueue.poll();
   } else {
    curFood = new int[] { -1, -1 };
   }

   // 2. grow the snake
   snake.addFirst(new int[] { nextX, nextY });

   score += 1;
   return score;
  }

  // purely move the snake
  snake.removeLast();

  for (int[] body : snake) {
   if (nextX == body[0] && nextY == body[1]) {
    // hit body
    return -1;
   }
  }
  snake.addFirst(new int[] { nextX, nextY });
  return score;
 }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */
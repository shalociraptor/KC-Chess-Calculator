import java.util.Scanner;
public class ChessCalculator {
   private double alliance1Points;
   private double alliance2Points;
   private double pointDifference;
   
   public double pointDifference (double alliance1, double alliance2) {
      double pointDifference = 0.0;
      
      this.alliance1Points = alliance1;
      this.alliance2Points = alliance2;
      
      if (alliance1 > alliance2) {
         pointDifference = alliance1 - alliance2;
      }
      else if (alliance2 > alliance1) {
         pointDifference = alliance2 - alliance1;
      }
      this.pointDifference = pointDifference;
      return pointDifference;
   }
   
   public double timeToReachGoal () { //returns hours
      int pointsGained;
      double curScore;
      double goal;
      double time = 0;
      int enemyPointsGained;
      Scanner scnr = new Scanner(System.in);
      
      System.out.println("What is your current score? ");
      curScore = scnr.nextDouble();
      System.out.println("How many points are being gained (per 15 mins)? ");
      pointsGained = scnr.nextInt();
      System.out.println("What is your goal? ");
      goal = scnr.nextDouble();
      System.out.println("How many points is the other alliance gaining (per 15 mins)? ");
      enemyPointsGained = scnr.nextInt();
      
      double difference;
      double pointsPerHr;
      double enemyPointsPerHr;
      double totalPoints;
      
      goal *= 1000;
      curScore *= 1000;
      
      difference = goal - curScore;
      
      pointsPerHr = pointsGained * 4;
      enemyPointsPerHr = enemyPointsGained * 4;
      
      time = difference / pointsPerHr;
      totalPoints = curScore + (time * pointsPerHr);
      
      double newGoal = goal + (time * enemyPointsPerHr);
      
      if (newGoal > totalPoints) {
         difference = newGoal - totalPoints;
         time += difference / pointsPerHr;
      }
  
      return time;
      }
      
   public boolean willWeMakeIt (double time) { // input hours
      double pointsGained;
      double curScore;
      double goal;
      int enemyPoints;
      boolean willWeMakeIt = false;
      Scanner scnr = new Scanner(System.in);
      
      System.out.println("How many points are being gained (per 15 mins)? ");
      pointsGained = scnr.nextInt();
      System.out.println("What is your current score? ");
      curScore = scnr.nextDouble();
      System.out.println("What is your goal? ");
      goal = scnr.nextDouble();
      System.out.println("How many points is the other alliance gaining (per 15 mins)? ");
      enemyPoints = scnr.nextInt();
      
      curScore *= 1000;
      goal *= 1000;
      double pointsGainedTot = time * (pointsGained * 4);
      double enemyPointsTot = time * (enemyPoints * 4);
      goal = goal + enemyPointsTot;
      
      if (goal > (curScore + pointsGainedTot)) {
         willWeMakeIt = false;
      }
      else if (goal <= (curScore + pointsGainedTot)) {
         willWeMakeIt = true;
      }
      
      return willWeMakeIt;
      }
      
   /*public double howManyPointsToCatchUp (double time) {
   how many pts needed to catch up to an alliance 
   based on how much time you have left & where you're at 
      double curScore;
      double goalScore;
      int pointsGained;
      int enemyPointsGained;
      Scanner scnr = new Scanner(System.in);
      
      System.out.println("What is your current score? ");
      curScore = scnr.nextDouble();
      curScore *= 1000;
      
      System.out.println("What is your goal score? ");
      goalScore = scnr.nextDouble();
      goalScore *= 1000;
      
      System.out.println("How many points are being gained (per 15 mins)? ");
      pointsGained = scnr.nextInt();
      pointsGained *= 4;
      
      System.out.println("How many points is the other alliance gaining (per 15 mins)? ");
      enemyPointsGained = scnr.nextInt();
      enemyPointsGained *= 4;
      
      
   }
   
   //public double whenWillWeMakeIt () {
   /* when will we make it to a cerrain # of pts 
   returns time 
   }
  */
}

         
  
         
      
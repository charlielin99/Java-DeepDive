class distance {
  public static point shortest_distance_travelled(int m, ArrayList<point> points) {
    
    point centroid = new point (0, 0);
    double x = 0;
    double y = 0;
    
    for (point current: points){
      x += current.getX();
      y += current.getY();
    }
    
    centroid.setX((int) Math.round(x / points.size()));
    centroid.setY((int) Math.round(y / points.size()));
    
    point minPoint = new point(0, 0);
    minPoint.setX(centroid.getX());
		minPoint.setY(centroid.getY());

		double min_distance = minPoint.calculate_sum_of_distances(points);
    
    for (int i=minPoint.getX()-1; i<minPoint.getX()+2; i++){
      for (int j=minPoint.getY()-1; j<minPoint.getY()+2; j++){
        if (i < 0 || j >= m){
          continue;
        }
        point newPoint = new point(i, j);
        double distance = newPoint.calculate_sum_of_distances(points);
        if (distance < min_distance){
          min_distance = distance;
          minPoint.setX(newPoint.getX());
          minPoint.setY(newPoint.getY());
        }
      }
    }
    
    return minPoint;
    
  }
}
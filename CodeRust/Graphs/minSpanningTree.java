class vertex {
  private int id;
  private boolean visited;

  public vertex(int id, boolean visited) {
    super();
    this.id = id;
    this.visited = visited;
  }

  int getId() {
    return id;
  }

  void setId(int id) {
    this.id = id;
  }

  boolean isVisited() {
    return visited;
  }

  void setVisited(boolean visited) {
    this.visited = visited;
  }
}

class edge {
  private int weight;
  private boolean visited;
  private vertex src;
  private vertex dest;

  public edge(int weight, boolean visited, vertex src,
      vertex dest) {
    this.weight = weight;
    this.visited = visited;
    this.src = src;
    this.dest = dest;
  }

  int getWeight() {
    return weight;
  }

  void setWeight(int weight) {
    this.weight = weight;
  }

  boolean isVisited() {
    return visited;
  }

  void setVisited(boolean visited) {
    this.visited = visited;
  }

  vertex getSrc() {
    return src;
  }

  void setSrc(vertex src) {
    this.src = src;
  }

  vertex getDest() {
    return dest;
  }

  void setDest(vertex dest) {
    this.dest = dest;
  }
}

class graph {
  private List<vertex> g;   //vertices
  private List<edge> e;     //edges

  int find_min_spanning_tree() {
    int vertex_count = 0;
    int weight = 0;

    // Add first vertex to the MST
    vertex current = g.get(0);
    current.setVisited(true);
    vertex_count++;

    // Construct the remaining MST using the
    // smallest weight edge
    while (vertex_count < g.size()) {
      edge smallest = null;
      for (int i = 0; i < e.size(); i++) {
        if (e.get(i).isVisited() == false
            && e.get(i).getDest().isVisited() == false) {
          smallest = e.get(i);
          break;
        }
      }

      for (int i = 0; i < e.size(); i++) {
        if (e.get(i).isVisited() == false) {
          if (e.get(i).getSrc().isVisited() == true
              && e.get(i).getDest().isVisited() == false
              && (e.get(i).getWeight() < smallest
                  .getWeight())) {
            smallest = e.get(i);
          }
        }
      }

      smallest.setVisited(true);
      smallest.getDest().setVisited(true);
      weight += smallest.getWeight();
      vertex_count++;
    }
    return weight;
  }
  
  public graph(List<vertex> g, List<edge> e) {
    super();
    this.g = g;
    this.e = e;
  }

  public List<vertex> getG() {
    return g;
  }

  public void setG(List<vertex> g) {
    this.g = g;
  }

  public List<edge> getE() {
    return e;
  }

  public void setE(List<edge> e) {
    this.e = e;
  }

  // This method returns the vertex with a given id if it
  // already exists in the graph, returns NULL otherwise
  vertex vertex_exists(int id) {
    for (int i = 0; i < g.size(); i++) {
      if (g.get(i).getId() == id) {
        return g.get(i);
      }
    }
    return null;
  }
}
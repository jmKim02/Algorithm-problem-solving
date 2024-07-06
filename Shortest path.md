# 다익스트라 알고리즘(Dijkstra)
정점들 사이의 `최단경로`를 구하는 알고리즘<br/>
> 💡출발 정점 s로부터 다른 모든 정점까지의 최단경를 구할 수 있다.<br/>
<br/>

> 다익스트라 활용 문제: [백준 1916번 최소비용 구하기](https://github.com/jmKim02/Algorithm-problem-solving/tree/24ff7b22b63eb2f4372844af28af2ce48c9eb3f1/Graph_Theory%20/G1916%20)

<br/>

### 기본 구조
- 비음수 가중치의 그래프에서만 활용 가능
- 인접 리스트 + 우선순위 큐
> [!TIP]
> 우선순위 큐를 구현하는데 두 가지 방법 중 선택 가능<br/>
> `힙`으로 구현: O(mlogn)<br/>
> `무순리스트`로 구현: O(n<sup>2</sup>)<br/>
> 희소그래프(즉, m < n<sup>2</sup>/logn)에 대해서는 힙 구현이 유리<br/>
> 밀집그래프(즉, m > n<sup>2</sup>/logn)에 대해서는 리스트 구현이 유리<br/>
> 자바의 PriorityQueue의 경우 기본이 힙 정렬이다.<br/>

<br/>

### Sudo Code

<p align="center"><img width="600" src="https://github.com/jmKim02/Algorithm-problem-solving/assets/174222202/7a7519d5-7b9e-4b27-acc3-01d79b599285">

<br/>

### 초기화
1. 시작 노드를 선택하고, 그 노드의 거리를 0으로 설정
2. 다른 모든 노드의 거리는 무한대로 설정
3. 시작 노드를 현재 노드로 설정하고, 이 노드를 방문한 노드로 표시

<br/>

### 알고리즘 수행
1. 현재 노드에서 인접한 모든 노드에 대해 거리를 계산
2. 계산된 거리와 현재 저장된 거리를 비교하여 더 작은 값으로 업데이트
3. 방문하지 않은 노드 중에서 가장 작은 거리를 가진 노드를 선택하여 다음 현재 노드로 설정
4. 모든 노드를 방문할 때까지 이 과정을 반복

<br/>

### 수행 예시

<p align="center"><img width="600" src="https://github.com/jmKim02/Algorithm-problem-solving/assets/174222202/fac32d8a-12a7-42a9-950a-a80af3225d71">
<p align="center"><img width="600" src="https://github.com/jmKim02/Algorithm-problem-solving/assets/174222202/d21404ac-85f3-4639-9044-02d57e770c65">

<br/>

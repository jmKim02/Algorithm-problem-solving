# 다익스트라 알고리즘(Dijkstra)
정점들 사이의 `최단경로`를 구하는 알고리즘<br/>
> 💡출발 정점 s로부터 다른 모든 정점까지의 최단경를 구할 수 있다.<br/>

<br/>

### 기본 구조
- 비음수 가중치의 그래프에서만 활용 가능
- 인접 리스트 구조 + 우선순위 큐
> [!TIP]
> 우선순위 큐를 구현하는데 두 가지 방법 중 선택 가능<br/>
> `힙`으로 구현: O(mlogn)<br/>
> `무순리스트`로 구현: O(n<sup>2</sup>)<br/>
> 희소그래프(즉, m < n<sup>2</sup>/logn)에 대해서는 힙 구현이 유리<br/>
> 밀집그래프(즉, m > n<sup>2</sup>/logn)에 대해서는 리스트 구현이 유리<br/>

<br/>

### Sudo Code

![image](https://github.com/jmKim02/Algorithm-problem-solving/assets/174222202/7a7519d5-7b9e-4b27-acc3-01d79b599285)

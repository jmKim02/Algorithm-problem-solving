# 1012번 - 인접한 배추

입력 예시2 M = 5, N = 3, K = 6의 경우로 분석<br/>
<br/>

|graph|0|1|2|3|4|
|---|---|---|---|----|----|
|0|0|0|0|0|1|
|1|0|0|0|0|0|
|2|1|1|1|1|1|

</br>

## public static class Graph
- private boolean value<br/>
- private boolean visited<br/>
<br/>
방문한 적이 없고, 배추가 심어져 있는 위치들로부터만 탐색 시작<br/>
-> 상 하 좌 우를 모두 탐색하며 방문한 위치를 표시하며 count.

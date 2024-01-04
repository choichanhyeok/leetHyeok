// 첫 시도: FOR 문으로 순회하며 상태검사 -> 택도 없음
// .. 뒤도 안돌아보고 힌트부터 까봄
// 두 번째 시도: 힌트에서 알려준대로 백트랙킹

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ipList = new ArrayList<>();
        backtrack(s, 0, "", 0, ipList);
        return ipList;
    }
    
    private void backtrack(String s, int index, String currentIP, int dotCount, List<String> ipList){
        
        // TODO 1. 탈출 조건: 점 개수 4개, index가 원문 String 길이 채웠을 때
        if (dotCount == 4 && index == s.length()){
            ipList.add(currentIP.substring(0, currentIP.length() - 1));
            return;
        }
        
        for (int i = 1; i < 4; i ++){
            // TODO 2. 길이 초과 건, 0으로 시작하거나 255가 넘는 건 처리
            if (index + i > s.length())
                break;
            
            String part = s.substring(index, index + i);
            if ((part.startsWith("0") && part.length() > 1) || (i == 3 && Integer.parseInt(part) > 255))
                continue;
            
            // TODO 3. 자격이 있는 IP 구문은 다음 IP 요소에 대한 재귀로 호출
            backtrack(s, index + i, currentIP + part + ".", dotCount + 1, ipList);
            
        }
    }
}

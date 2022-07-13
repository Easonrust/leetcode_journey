class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> res = new ArrayList<>();
        Map<String, Integer> repForDomain = new HashMap<>();
        for(String cpdomain:cpdomains){
            String[] repAndDomain = cpdomain.split("\\s+");
            List<String> subdomains = getSubDomains(repAndDomain[1]);
            int rep = Integer.valueOf(repAndDomain[0]);
            for(String subdomain:subdomains){
                repForDomain.put(subdomain, repForDomain.getOrDefault(subdomain, 0)+rep);
            }
        }
        
        for(String domain:repForDomain.keySet()){
            String cpdomain = String.valueOf(repForDomain.get(domain)) + " " + domain;
            res.add(cpdomain);
        }
        return res;
    }
    
    private List<String> getSubDomains(String domain){
        String[] arr = domain.split("\\.");
        List<String> res = new ArrayList<>();
        for(int i=0; i<arr.length; ++i){
            StringBuilder sb = new StringBuilder();
            sb.append(arr[i]);
            for(int j=i+1; j<arr.length; ++j){
                sb.append(".");
                sb.append(arr[j]);
            }
            res.add(sb.toString());
        }
        
        return res;
    }
}

// \\s+ 分割一个或多个空格
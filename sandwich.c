int main() {
    int T,i;
    scanf("%d", &T);
    
    for(i = 0 ; i < T; i++){
        int n, k;
        scanf("%d %d", &n, &k);
        
        int count=n;
        int remain = 0;
        int a;
        
        while(n >= k){
            a = n/k;
            remain = n % k;
            count = count+a;
            n = a + remain;
        }
        printf("%d\n", count);
    }
    return 0;
}
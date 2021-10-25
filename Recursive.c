#include <stdio.h>
#include <string.h>
#include <math.h>
#include <stdlib.h>

char string[100];
int lookahead = 0;
char token;


char getToken();
void fB();
void fA();
void fS();


char getToken(){
    lookahead = lookahead + 1;
    return string[lookahead];
}

void fB(){
    if(token=='b'){
        token=getToken();
        fA();
    } else if(token=='a' || token=='c'){
        fS();
    } else {
        printf("Error in Parsing");
        exit(1);
    }
}

void fA(){
    if(token=='b'){
        token=getToken();
        if(token=='a')
            token=getToken();
        else{
            printf("Error in Parsing");
            exit(1);
        }
    } else if(token=='a' || token=='c'){
        fS();
        fB();
    } else {
        printf("Error in Parsing");
        exit(1);
    }
}

void fS(){
    if(token=='a'){
        token=getToken();
        fS();
        fA();
    } else if(token == 'c')
        token=getToken();
    else{
        printf("Error in Parsing");
        exit(1);
    }
}

int main() {
    scanf("%s", string);
    
    int dollar_position=0;
    int i=0;
    while(string[i] != '\0'){
        i++;
    }
    
    dollar_position=i;
    string[dollar_position]='$';
    string[dollar_position+1]='\0';
    
    token=string[0];

    fS();
    
    if(token == '$')
        printf("Sucessfully Parsed");
    else
        printf("Error in Parsing");
    return 0;
}

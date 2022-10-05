#include <stdio.h>

int main(){
	int array[10] = {3,2,4,6,7,5,8,9,10,1};
	int min;
	int temp;
	int index;
	
	for	(int i = 0; i < 10 ; i++){
		
		min = 9999;
		for	(int j = i ; j < 10 ; j++){
			if(min > array[j]){
				min = array[j];
				index = j;
			}
		}
		
		temp = array[i];
		array[i] = array[index];
		array[index] = temp;
	}
	
	for	(int i = 0; i < 10 ; i++){
		printf("%d", array[i]);
	}
}

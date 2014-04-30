package utils;

public class Ordenamiento {
	
	public static int[] ordenarConBurbuja(int[] array) {
		int temp;
		for(int i=0; i<array.length; i++) {
			for(int j=(i+1); j<array.length; j++) {
				if(array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	public static int[] ordenarConShell(int[] array) {
		int i, d, auxiliar;
		d = array.length;
		do {
			d = d/2;
			do {
				auxiliar = 0;
				i = -1;
				do {
					i++;
					if(array[i] > array[i+d]) {
						int aux = array[i];
						array[i] = array[i+d];
						array[i] = array[i+d];
						array[i+d] = aux;
					}
				} while( (1+d) != (array.length - 1) );
			} while(auxiliar != 0);
		} while(d != 1);
		return array;
	}
}
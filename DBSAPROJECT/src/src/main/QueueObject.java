package src.main;

import src.input.InputStreamAbs;

public class QueueObject implements Comparable<QueueObject> {

//	int arrayNumber;
	InputStreamAbs input;
	int value;

	public QueueObject(	InputStreamAbs input, int value) {
	    this.input=input;
		this.value = value;
	}

	@Override
	public int compareTo(QueueObject o) {
		if(value>o.value) return 1;
		if(value<o.value) return -1;
		else return 0;
	}
}

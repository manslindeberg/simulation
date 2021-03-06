
/* This Class implements a list with signals using a single-linked list.*/

public class SignalList{
	private  static Signal list, last;

	SignalList(){
    	list = new Signal();
    	last = new Signal();
    	list.next = last;
	}

	/* This is essentially a queue that is based on lowest */
	public static void SendSignal(int type, Proc source, Proc dest, double arrtime){
 	Signal dummy, predummy;
 	Signal newSignal = new Signal();
 	newSignal.source = source;
 	newSignal.signalType = type;
 	newSignal.destination = dest;
 	newSignal.arrivalTime = arrtime;
 	predummy = list;
 	dummy = list.next;
 	while ((dummy.arrivalTime < newSignal.arrivalTime) & (dummy != last)){
 		predummy = dummy;
 		dummy = dummy.next;
 	}
 	predummy.next = newSignal;
 	newSignal.next = dummy;
 }

	public static Signal FetchSignal(){
		Signal dummy;
		dummy = list.next;
		list.next = dummy.next;
		dummy.next = null;
		return dummy;
	}
}

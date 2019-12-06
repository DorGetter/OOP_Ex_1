package Ex1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;


public class Functions_GUI implements functions {

	ArrayList<function> list = new ArrayList<function>();

	@Override
	public boolean add(function arg0) {
		try {
			list.add(arg0);
			return true;
		}
		catch (Exception e) {
			throw new RuntimeException("Unable to add " + arg0.toString());
		}
	}

	@Override
	public boolean addAll(Collection<? extends function> arg0) {
		if (list.addAll(arg0)) return true;

		return false;
	}

	@Override
	public void clear() {
		list.clear();

	}

	@Override
	public boolean contains(Object arg0) {
		if(list.contains(arg0)) return true;
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		if(list.containsAll(arg0)) return true;
		return false;
	}

	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<function> iterator() {
		return list.iterator();
	}

	@Override
	public boolean remove(Object arg0) {
		if(list.remove(arg0)) return true ;

		return false;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		if(list.removeAll(arg0)) return true; 

		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		if(list.retainAll(arg0)) return true; 

		return false;
	}

	@Override
	public int size() {
		return list.size();
	}

	@Override
	public Object[] toArray() {
		return list.toArray();
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		return list.toArray(arg0);
	}

	@Override
	public void initFromFile(String file) throws IOException {

	}

	@Override
	public void saveToFile(String file) throws IOException {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawFunctions(int width, int height, Range rx, Range ry, int resolution) {

		StdDraw.setCanvasSize(width,height);
		StdDraw.setPenRadius(0.009);
		StdDraw.setPenColor(StdDraw.BLACK);

		StdDraw.setXscale(rx.get_min(),rx.get_max());
		StdDraw.setYscale(ry.get_min(),ry.get_max());
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());

		function p1 = new Polynom("5");
		StdDraw.setPenColor(StdDraw.RED);
		StdDraw.setPenRadius(0.005);

		//		for (double i = rx.get_min(); i < rx.get_max()+1; i+=rx.get_max()/resolution) {
		//			StdDraw.point(i,p1.f(i));
		//		}

		for (int j = 0; j < list.size(); j++) {
			for (double i = rx.get_min(); i < rx.get_max()+1; i+=rx.get_max()/resolution) {
				if(ry.isIn(list.get(j).f(i))) {
					StdDraw.line(i, list.get(j).f(i), i+1, list.get(j).f(i+1));
				}
			}
		}

	}

	@Override
	public void drawFunctions(String json_file) {
		// TODO Auto-generated method stub

	}

	public void drawFunctions() {
		
		int width = 1024;
		int height = 1024;
		Range rx = new Range(-100, 100);
		Range ry = new Range(-100,100);
		int resolution = 2000;
		StdDraw.setCanvasSize(width,height);
		StdDraw.setPenRadius(0.009);
		StdDraw.setPenColor(StdDraw.BLACK);

		StdDraw.setXscale(rx.get_min(),rx.get_max());
		StdDraw.setYscale(ry.get_min(),ry.get_max());
		StdDraw.line(rx.get_min(), 0, rx.get_max(), 0);
		StdDraw.line(0, ry.get_min(), 0, ry.get_max());

		function p1 = new Polynom("5");
		StdDraw.setPenRadius(0.005);
		
		for (int j = 0; j < list.size(); j++) {
			int r= (int) (Math.random()*255);
			int g= (int) (Math.random()*255);
			int b= (int) (Math.random()*255);
			
			System.out.println(r+" "+g+ " "+b);
			
			for (double i = rx.get_min(); i < rx.get_max()+1; i+=rx.get_max()/resolution) {
				StdDraw.setPenColor(r, g, b);
				if(ry.isIn(list.get(j).f(i)) ||ry.isIn(list.get(j).f(i+1)) ) {
					StdDraw.line(i, list.get(j).f(i), i+1, list.get(j).f(i+1));
				}
			}
		}

	}

	public ComplexFunction get(int i) {
		// TODO Auto-generated method stub
		return null;
	}

}
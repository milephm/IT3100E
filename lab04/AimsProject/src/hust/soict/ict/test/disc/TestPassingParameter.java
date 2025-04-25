package hust.soict.ict.test.disc;

import hust.soict.ict.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc(1, "Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc(2, "Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("Jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());

//        swapNew(jungleDVD, cinderellaDVD);
//        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2) {
        Object tmp = o1;
        o1 = o2;
        o2 = tmp;
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(3, oldTitle);
    }
    // java is always a pass by value programming language
    // swap() method that can correctly swap the two objects

//    public static void swapNew(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
//        DigitalVideoDisc tmp = new DigitalVideoDisc(dvd1.getTitle());
//        dvd1.setTitle(dvd2.getTitle());
//        dvd2.setTitle(tmp.getTitle());
//    }
}




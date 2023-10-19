package Week2;

public class FrequencyOfELements {
    public static void main(String[] args) {
        int[] dizi = {1, 2, 3, 2, 4, 1, 5, 2, 3};
        int[] frekanslar = frekanslariHesapla(dizi);

        // Sonuçları ekrana yazdıralım
        for (int i = 0; i < frekanslar.length; i++) {
            if (frekanslar[i] != 0) {
                System.out.println(i + " elemanı " + frekanslar[i] + " kez tekrar edildi.");
            }
        }
    }

    public static int[] frekanslariHesapla(int[] dizi) {
        int[] frekanslar = new int[50]; // Dizideki elemanların değerlerini göz önünde bulundurarak bir boyut belirleyin

        for (int eleman : dizi) {
            frekanslar[eleman]++;//bu kısımda tekrarlanan sayıları değer olarak atıyoruz örneğin
        }                        //2 sayısı 3 defa tekrarlanıyorsa frekanslar dizisinin 2. elemanının değeri 3 olur.

        return frekanslar;
    }
}

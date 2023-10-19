package Week2.BoxMatch;

public class Match {
    Fighter f1;
    Fighter f2;
    int maxWeight;
    int minWeight;

    Match(Fighter f1, Fighter f2, int maxWeight, int minWeight){
        this.f1 = f1;
        this.f2 = f2;
        this.maxWeight = maxWeight;
        this.minWeight  =minWeight;
    }
    public void run(){
        if (isChceck()){
            while (this.f1.health > 0 && this.f2.health > 0){
                System.out.println("========NEW ROUND========");

                if (firstHit()){
                    System.out.println("f1 önce vurdu");
                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }

                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }

                }
                else {
                    System.out.println("f2 önce vurdu");
                    this.f1.health = this.f2.hit(this.f1);
                    if (isWin()) {
                        break;
                    }

                    this.f2.health = this.f1.hit(this.f2);
                    if (isWin()) {
                        break;
                    }

                }



                System.out.println(this.f1.name + " Sağlık : " + this.f1.health);
                System.out.println(this.f2.name + " Sağlık : " + this.f2.health);

            }
        }
        else {
            System.out.println("Sporcuların sikletleri uyuşmuyor.");
        }

    }

    boolean isChceck(){
        return (this.f1.weight >= minWeight && this.f1.weight <= maxWeight) && (this.f2.weight >= minWeight && this.f2.weight <= maxWeight);
    }
    boolean isWin(){
        if (this.f1.health == 0){
            System.out.println(this.f2.name + " Kazandı !");
            return true;
        }
        if (this.f2.health == 0){
            System.out.println(this.f1.name + " Kazandı !");
            return true;
        }
        return false;
    }
    boolean firstHit(){
        double randomNum = Math.random() * 100;
        return randomNum > 50;
    }
}

package examen.eduardoyurencb.capitalsocial.promotion.model;


public class PromotionView {
    private String namePlace;
    private String promotion;

    public PromotionView(String namePlace, String promotion) {
        this.namePlace = namePlace;
        this.promotion = promotion;
    }

    public String getNamePlace() {
        return namePlace;
    }

    public void setNamePlace(String namePlace) {
        this.namePlace = namePlace;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }
}

package examen.eduardoyurencb.capitalsocial.base.presenter;


import examen.eduardoyurencb.capitalsocial.base.view.View;

public class Presenter<V extends View> {

    private V view;

    /**
     * Method to bind view
     * */
    public void bindView(V view){
        this.view = view;
    }

    /**
     * Method to get an instance of view
     * */
    public V getView(){
        return view;
    }

}

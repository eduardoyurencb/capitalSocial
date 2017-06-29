package examen.eduardoyurencb.capitalsocial.base.presenter;


import examen.eduardoyurencb.capitalsocial.base.view.View;

/**
 * @author Leonel Mendez
 * Generic class to create a presenter to handle actions
 */

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

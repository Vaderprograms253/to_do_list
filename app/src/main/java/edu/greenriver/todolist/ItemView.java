package edu.greenriver.todolist;

public class ItemView {
    private String item;
    private boolean checked;

    public ItemView(String item){
        this.item = item;
        this.checked = false;

    }
    public String getItem() {
        return item;
    }

    public void setChecked(boolean checked){
        this.checked = checked;
    }

}

package com.bizruntime.datastructure;

public class TwoChildNode {
	protected Object data;
    protected TwoChildNode left,right;

    public TwoChildNode(){
        data = null;
        left = right = null;
    }
    public TwoChildNode(Object d){
        data = d;
        left = right = null;
    }
    public void setLeft(TwoChildNode l){
        left = l;
    }
    public void setRight(TwoChildNode r){
        right = r;
    }
    public void setData(Object d){
        data = d;
    }
    public TwoChildNode getLeft(){
        return left;
    }
    public TwoChildNode getRight(){
        return right;
    }
    public Object getData(){
        return data;
    }
    public String toString(){
        return ""+data;
    }

}

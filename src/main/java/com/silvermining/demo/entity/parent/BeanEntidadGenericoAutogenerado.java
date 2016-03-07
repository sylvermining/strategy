package com.silvermining.demo.entity.parent;


import java.io.Serializable;

public class BeanEntidadGenericoAutogenerado
        implements Serializable {
	
	private static final long serialVersionUID = 528370200912819127L;
	
	protected Long id;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
}

package am2.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class AM2ModelRenderer extends ModelRenderer{

	private float restRotationX;
	private float restRotationY;
	private float restRotationZ;

	public AM2ModelRenderer(ModelBase par1ModelBase){
		super(par1ModelBase);
	}

	public AM2ModelRenderer(ModelBase par1ModelBase, int par2, int par3){
		super(par1ModelBase, par2, par3);
	}

	public AM2ModelRenderer(ModelBase par1ModelBase, String par2){
		super(par1ModelBase, par2);
	}

	public void storeRestRotations(){
		restRotationX = this.rotateAngleX;
		restRotationY = this.rotateAngleY;
		restRotationZ = this.rotateAngleZ;
	}

	public float getRestRotationX(){
		return restRotationX;
	}

	public float getRestRotationY(){
		return restRotationY;
	}

	public float getRestRotationZ(){
		return restRotationZ;
	}

	public void resetToRestRotations(){
		this.rotateAngleX = restRotationX;
		this.rotateAngleY = restRotationY;
		this.rotateAngleZ = restRotationZ;
	}
}

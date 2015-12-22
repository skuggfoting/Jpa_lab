package se.sml.ecommerce.model;

public final class OrderRow
{
	private final int quantity;
	private final Product product;
	private double sum;

	public OrderRow(Product product, int quantity)
	{
		this.quantity = quantity;
		this.product = product;
	}

	public int getQuantity()
	{
		return quantity;
	}

	public double getSum()
	{
		sum = quantity * product.getPrice();
		return sum;
	}

	@Override
	public boolean equals(Object otherObj)
	{
		if (this == otherObj)
		{
			return true;
		}

		if (otherObj instanceof OrderRow)
		{
			OrderRow otherRows = (OrderRow) otherObj;
			return this.product.getProductName().equals(otherRows.product.getProductName());
		}
		return false;
	}

	@Override
	public int hashCode()
	{
		int result = 1;
		result += 37 * product.getProductName().hashCode();
		return result;
	}
}

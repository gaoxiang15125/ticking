package po;

public enum OrderStatus {

	finished{
		//订单交易成功，且订票成功
	},
	over{
		//订单交易成功，但订票失败
	},
	undo{
		//订单交易成功，但被用户撤销
	},
	undone{
		//订单未进行交易（未付款）
	}
}

class BuyAndSellStock {
  def maxProfit(prices: Array[Int]): Int = {
    def helper(prices: Array[Int], minPrice: Int, maxProfit: Int, idx: Int): Int = {
      if (idx >= prices.length) maxProfit
      else {
        val currentPrice = prices(idx)
        val newMinPrice = if (currentPrice < minPrice) currentPrice else minPrice
        val newMaxProfit = if (currentPrice - newMinPrice > maxProfit) currentPrice - newMinPrice else maxProfit
        helper(prices, newMinPrice, newMaxProfit, idx + 1)
      }
    }

    if (prices.isEmpty) 0
    else helper(prices, prices(0), 0, 1)
  }
}


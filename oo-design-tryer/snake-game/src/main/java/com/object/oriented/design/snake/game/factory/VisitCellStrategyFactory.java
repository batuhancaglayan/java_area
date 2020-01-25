package com.object.oriented.design.snake.game.factory;

import com.object.oriented.design.snake.game.model.Cell.CellType;
import com.object.oriented.design.snake.game.strategy.VisitEmptyCellStrategy;
import com.object.oriented.design.snake.game.strategy.VisitFoodCellStrategy;
import com.object.oriented.design.snake.game.strategy.VisitPoisenCellStrategy;
import com.object.oriented.design.snake.game.strategy.VisitCellStrategy;

public final class VisitCellStrategyFactory {

	public static VisitCellStrategy getEatCellStrategy(CellType cellType) {
		
		VisitCellStrategy strategy = null;
		switch (cellType) {
		case EMPTY:
			strategy = new VisitEmptyCellStrategy();
			break;
			
		case FOOD:
			strategy = new VisitFoodCellStrategy();
			break;
			
		case POISON:
			strategy = new VisitPoisenCellStrategy();
			break;

		default:
			break;
		}
		
		return strategy;	
	}
}

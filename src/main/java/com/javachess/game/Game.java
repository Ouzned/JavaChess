package com.javachess.game;

import com.javachess.board.Board;
import com.javachess.board.Square;
import com.javachess.board.initializer.BoardInitializer;
import com.javachess.converter.NotationConverter;

public class Game {
	private Board board;
	private StateContext context;
	private NotationConverter converter;

	public Game(NotationConverter converter, BoardInitializer initializer) {
		this.board = new Board();
		this.converter = converter;
		this.context = new StateContext();
		
		initializer.init(board);
	}

	public void start() {
		while (true) {
			String notation = null;//currentPlayer.getNextMove(this);
			
			Square srcSquare = converter.getSrc(notation);
			Square dstSquare = converter.getDst(notation);
			
			srcSquare.equals(dstSquare);
			
			// TODO: execute move
			context.notifyMove(null, board);
		}
	}

	public void undo() {
		context.lastMove().undo();
		context.undo();
	}
}
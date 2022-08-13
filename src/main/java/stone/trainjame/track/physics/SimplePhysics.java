/**
 * This file is part of TrainJame. 
 * Copyright (c) 2022, Stone, All rights reserved.
 * 
 * TrainJame is free software: you can redistribute it and/or
 * modify it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * TrainJame is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with TrainJame. If not, see <https://www.gnu.org/licenses/>.
 */
package stone.trainjame.track.physics;

import org.decimal4j.api.Decimal;
import org.decimal4j.scale.ScaleMetrics;

/**
 * @param <P>
 * @param <P>
 * 
 */
public class SimplePhysics<P extends ScaleMetrics> implements Physics<P> {

	@Override
	public boolean canStart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Decimal<P> position(long time) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void tick() {
		return;
	}

}

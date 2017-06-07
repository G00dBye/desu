/*
    This file is part of Desu: MapleStory v62 Server Emulator
    Copyright (C) 2017  Brenterino <therealspookster@gmail.com>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
package field;

import client.Client;
import player.Player;

/**
 *
 * @author Brent
 */
public abstract class FieldLife implements FieldObject {

    public static final int NO_CONTROLLER = -1;
    
    public abstract void sendControlGain(Client mc);
    public abstract void sendControlLoss(Client mc);
    
    private int oid;
    private int controller = NO_CONTROLLER;

    public int getController() {
        return controller;
    }
    
    public void giveControl(Player p) {
        if (p != null) {
            controller = p.getOid();
            p.addControlled(getOid());
            sendControlGain(p.getClient());
        }
    }

    public void removeControl(Player p) {
        if (p != null) {
            p.removeControlled(getOid());
            sendControlLoss(p.getClient());
        }
        controller = NO_CONTROLLER;
    }
    
    @Override
    public final int getOid() {
        return oid;
    }
    
    @Override
    public final void setOid(int oid) {
        this.oid = oid;
    }
}

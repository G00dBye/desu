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
package world.handler;

import net.PacketReader;
import netty.PacketHandler;
import world.AccountStorage;
import world.World;

/**
 *
 * @author Brent
 */
public class UpdateAccountStateHandler implements PacketHandler<World> {

    @Override
    public boolean validateState(World w) {
        return true;
    }

    @Override
    public void handle(World w, PacketReader r) {
        int accountId = r.readInteger();
        int cid = r.readInteger();
        String name = r.readMapleString();
        boolean gm = r.readBool();
        String lastIP = r.readMapleString();
        
        AccountStorage.addIncoming(cid, accountId, name, gm, lastIP);
    }
}

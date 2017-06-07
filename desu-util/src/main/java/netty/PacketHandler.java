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
package netty;

import net.PacketReader;

/**
 * Represents a packet handler for a received MapleStory packet.
 * 
 * @author Brent
 * @param <E> specific type of NettyClient -> more than likely the inheritance
 */
public interface PacketHandler<E extends NettyClient> {
    
    public boolean validateState(E c);
    
    public void handle(E c, PacketReader r);
}

/*
 * Open Parties and Claims - adds chunk claims and player parties to Minecraft
 * Copyright (C) 2022-2023, Xaero <xaero1996@gmail.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of version 3 of the GNU Lesser General Public License
 * (LGPL-3.0-only) as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received copies of the GNU Lesser General Public License
 * and the GNU General Public License along with this program.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package xaero.pac.common.packet.claims;

import net.minecraft.network.FriendlyByteBuf;
import xaero.pac.OpenPartiesAndClaims;
import xaero.pac.common.server.lazypacket.LazyPacket;

import java.util.function.Consumer;
import java.util.function.Function;

public class ClientboundClaimsClaimUpdateNextXPosPacket extends LazyPacket<LazyPacket.Encoder<ClientboundClaimsClaimUpdateNextXPosPacket>, ClientboundClaimsClaimUpdateNextXPosPacket> {

	public static final Encoder<ClientboundClaimsClaimUpdateNextXPosPacket> ENCODER = new Encoder<>();

	public ClientboundClaimsClaimUpdateNextXPosPacket() {
		super();
	}

	@Override
	protected Encoder<ClientboundClaimsClaimUpdateNextXPosPacket> getEncoder() {
		return ENCODER;
	}

	@Override
	protected void writeOnPrepare(Encoder<ClientboundClaimsClaimUpdateNextXPosPacket> encoder, FriendlyByteBuf u) {
	}
	
	public static class Decoder implements Function<FriendlyByteBuf, ClientboundClaimsClaimUpdateNextXPosPacket> {

		@Override
		public ClientboundClaimsClaimUpdateNextXPosPacket apply(FriendlyByteBuf input) {
			try {
				return new ClientboundClaimsClaimUpdateNextXPosPacket();
			} catch(Throwable t) {
				OpenPartiesAndClaims.LOGGER.error("invalid packet", t);
				return null;
			}
		}
		
	}
	
	public static class ClientHandler implements Consumer<ClientboundClaimsClaimUpdateNextXPosPacket> {
		
		@Override
		public void accept(ClientboundClaimsClaimUpdateNextXPosPacket t) {
			OpenPartiesAndClaims.INSTANCE.getClientDataInternal().getClientClaimsSyncHandler().onClaimUpdateNextXPos();
		}
		
	}

}

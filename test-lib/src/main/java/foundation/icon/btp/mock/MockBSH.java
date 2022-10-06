/*
 * Copyright 2021 ICON Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package foundation.icon.btp.mock;

import foundation.icon.btp.lib.BSH;
import foundation.icon.score.client.ScoreClient;
import score.Address;
import score.annotation.EventLog;
import score.annotation.External;
import score.annotation.Payable;

import java.math.BigInteger;

/**
 * for BMC
 */
@ScoreClient
public interface MockBSH extends BSH {

    @Payable
    @External
    void sendMessage(Address _bmc, String _to, String _svc, BigInteger _sn, byte[] _msg);

    @EventLog(indexed = 1)
    void SendMessage(BigInteger _nsn, String _to, String _svc, BigInteger _sn, byte[] _msg);

    @EventLog
    void HandleBTPMessage(String _from, String _svc, BigInteger _sn, byte[] _msg);

    @EventLog
    void HandleBTPError(String _src, String _svc, BigInteger _sn, long _code, String _msg);
}

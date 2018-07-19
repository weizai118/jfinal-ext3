/*
 * Copyright 2018 Jobsz (zcq@zhucongqi.cn)
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
*/
package com.jfinal.ext.plugin.redis;

import java.io.Serializable;

import com.jfinal.log.Log;


public class QueueProducer {
	
   //TODO un used?
	protected final Log LOG = Log.getLog(QueueProducer.class);
    
    String queueName;

    private QueueProducer(String queueName) {
        this.queueName = queueName;
    }

    public static QueueProducer create(String queueName) {
        return new QueueProducer(queueName);
    }

    public boolean publish(Serializable message) {
        return JedisKit.lpush("queue-" + queueName, message) >= 1 ? true : false;
    }
}

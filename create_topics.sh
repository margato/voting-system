docker exec voting_kafka_broker \
kafka-topics --bootstrap-server voting_kafka_broker:9092 \
             --create \
             --topic votings.votes.new

docker exec voting_kafka_broker \
kafka-topics --bootstrap-server voting_kafka_broker:9092 \
             --create \
             --topic votings.votes.process
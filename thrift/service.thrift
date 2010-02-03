namespace java am.ik.thrift.service

struct InputDto {
	1: string id;
}

struct OutputDto {
	1: string message;
}

service ServiceFacade {
	OutputDto execute(1: InputDto input);
}